(ns components)

(defn layout [request body]
  [:html
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible", :content "IE=edge"}]
    [:meta {:name "viewport", :content "width=device-width, initial-scale=1"}]
    [:title "Magehash - Crypto Miner Shield"]
    [:link {:href "https://fonts.googleapis.com/css?family=Lato:400,400i|Roboto:500", :rel "stylesheet"}]
    [:link {:href "/css/style.css" :rel "stylesheet"}]
    [:script {:defer "" :src "https://unpkg.com/scrollreveal@4.0.0/dist/scrollreveal.min.js"}]
    [:script {:defer "" :src "/js/main.min.js"}]]

   [:body {:class "is-boxed has-animations"}
    body]])
