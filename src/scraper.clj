(ns scraper
  (:require [chrome]
            [clojure.string :as string]
            [clojure.java.io :as io]
            [coast :refer [q]]
            [clojure.data.json :as json]
            [mailer])
  (:gen-class))

(defn scripts [v]
  (->> (map :src v)
       (filter some?)))

(defn miners [domains tags]
  (mapcat identity
    (filter
      #(not (empty? %))
      (for [d domains]
        (filter #(.contains % d) tags)))))

(defn scrape [url]
  (println "[scraper/scrape] Scraping url" url)
  (let [tags (-> (chrome/with-connection [c "http://localhost:9222"]
                   (chrome/navigate c {:url url :timeout 30000})
                   (chrome/evaluate c "JSON.stringify([].slice.call(document.scripts).map(function(s) { return { src: s.src } }))"))
                 :result :result :value
                 (json/read-str :key-fn keyword)
                 (scripts))
        domains (-> (io/resource "no-coin-list.txt")
                    (slurp)
                    (string/split #"\n")
                    (set))
        _ (println "[scraper/scrape] Found" (count tags) "script tag(s) with a src attribute")
        _ (println "[scraper/scrape] Comparing against miner domains list")
        results (miners domains tags)]
    (println "[scraper/scrape] Found" (count results) "miner script tag(s)")
    results))

(defn send-email [m]
  (println "[scraper/scrape] Sending email to" (:email m))
  (mailer/mail :txt/alert (:email m) (update m :scripts #(string/join "\n" %))))

(defn -main []
  (let [leads (q '[:select lead/url lead/email])]
    (println "[scraper/-main] Scraping" (count leads) "site(s)")
    (doall
      (for [{:lead/keys [email url]} leads]
        (let [scripts (scrape url)]
          (when (not (empty? scripts))
            (send-email {:email email
                         :url url
                         :scripts scripts})))))
    (System/exit 0)))
