(ns home.index
  (:require [coast :refer [flash form action-for redirect validate rescue transact url-for]]))

(defn view [request]
  [:div {:class "body-wrap boxed-container"}
   (when (some? (:flash request))
     [:div {:class "text-center text-light" :style "padding: 20px; background-color: #528EE8; width: 100%; z-index: 1;"}
      (:flash request)])
   [:header {:class "site-header"}
    [:div {:class "container"}
     [:div {:class "site-header-inner"}
      [:div {:class "brand header-brand"}
       [:h1 {:class "m-0"}
        [:a {:href "#"}
         [:img {:src "/unicorn.png"}]]]]]]]

   [:main
    [:section {:class "hero text-center"}
     [:div {:class "container-sm"}
      [:div {:class "hero-inner"}
       [:h1 {:class "hero-title h2-mobile mt-0 is-revealing"}
        "Don't get Cryptojacked"]
       [:p {:class "hero-paragraph is-revealing"}
        "Get an email if someone malicious manages to sneak in a crypto miner in your website"]
       (form (action-for ::action)
         [:div {:class "hero-form newsletter-form field field-grouped is-revealing"}
          [:div {:class "control control-expanded"}
           [:input {:class "input", :type "text", :name "url", :placeholder "Your Website URL" :required ""}]
           [:div {:class "text-left text-sm" :style "color: #EF768C"} (or (-> request :errors :url)
                                                                          (-> request :errors :lead/url))]]]

         [:br]
         [:div {:class "hero-form newsletter-form field field-grouped is-revealing"}
          [:div {:class "control control-expanded"}
           [:input {:class "input", :type "email", :name "email", :placeholder "Your best email…" :required ""}]
           [:div {:class "text-left text-sm" :style "color: #EF768C"} (or (-> request :errors :email)
                                                                          (-> request :errors :lead/email))]]

          [:div {:class "control"}
           [:input {:type "submit" :class "button button-primary button-block button-shadow", :href "#"
                    :value "Start Monitoring"}]]])

       [:div {:class "hero-browser"}
        [:div {:class "bubble-3 is-revealing"}
         [:svg {:width "427", :height "286", :viewbox "0 0 427 286", :xmlns "http://www.w3.org/2000/svg", :xmlns:xlink "http://www.w3.org/1999/xlink"}
          [:defs
           [:path {:d "M213.5 286C331.413 286 427 190.413 427 72.5S304.221 16.45 186.309 16.45C68.396 16.45 0-45.414 0 72.5S95.587 286 213.5 286z", :id "bubble-3-a"}]]

          [:g {:fill "none", :fill-rule "evenodd"}
           [:mask {:id "bubble-3-b", :fill "#fff"}
            [:use {:xlink:href "#bubble-3-a"}]]

           [:use {:fill "#4E8FF8", :xlink:href "#bubble-3-a"}]
           [:path {:d "M64.5 129.77c117.913 0 213.5-95.588 213.5-213.5 0-117.914-122.779-56.052-240.691-56.052C-80.604-139.782-149-201.644-149-83.73c0 117.913 95.587 213.5 213.5 213.5z", :fill "#1274ED", :mask "url(#bubble-3-b)"}]
           [:path {:d "M381.5 501.77c117.913 0 213.5-95.588 213.5-213.5 0-117.914-122.779-56.052-240.691-56.052C236.396 232.218 168 170.356 168 288.27c0 117.913 95.587 213.5 213.5 213.5z", :fill "#75ABF3", :mask "url(#bubble-3-b)"}]]]]


        [:div {:class "bubble-4 is-revealing"}
         [:svg {:width "230", :height "235", :viewbox "0 0 230 235", :xmlns "http://www.w3.org/2000/svg", :xmlns:xlink "http://www.w3.org/1999/xlink"}
          [:defs
           [:path {:d "M196.605 234.11C256.252 234.11 216 167.646 216 108 216 48.353 167.647 0 108 0S0 48.353 0 108s136.959 126.11 196.605 126.11z", :id "bubble-4-a"}]]

          [:g {:fill "none", :fill-rule "evenodd"}
           [:mask {:id "bubble-4-b", :fill "#fff"}
            [:use {:xlink:href "#bubble-4-a"}]]

           [:use {:fill "#7CE8DD", :xlink:href "#bubble-4-a"}]
           [:circle {:fill "#3BDDCC", :mask "url(#bubble-4-b)", :cx "30", :cy "108", :r "108"}]
           [:circle {:fill "#B1F1EA", :opacity ".7", :mask "url(#bubble-4-b)", :cx "265", :cy "88", :r "108"}]]]]


        [:div {:class "hero-browser-inner is-revealing"}
         [:svg {:width "800", :height "450", :viewbox "0 0 800 450", :xmlns "http://www.w3.org/2000/svg", :xmlns:xlink "http://www.w3.org/1999/xlink"}
          [:defs
           [:lineargradient {:x1 "50%", :y1 "0%", :x2 "50%", :y2 "100%", :id "browser-a"}
            [:stop {:stop-color "#F6F8FA", :stop-opacity ".48", :offset "0%"}]
            [:stop {:stop-color "#F6F8FA", :offset "100%"}]]

           [:lineargradient {:x1 "50%", :y1 "100%", :x2 "50%", :y2 "0%", :id "browser-b"}
            [:stop {:stop-color "#F6F8FA", :stop-opacity ".48", :offset "0%"}]
            [:stop {:stop-color "#F6F8FA", :offset "100%"}]]

           [:lineargradient {:x1 "100%", :y1 "-12.816%", :x2 "0%", :y2 "-12.816%", :id "browser-c"}
            [:stop {:stop-color "#F6F8FA", :stop-opacity "0", :offset "0%"}]
            [:stop {:stop-color "#E3E7EB", :offset "50.045%"}]
            [:stop {:stop-color "#F6F8FA", :stop-opacity "0", :offset "100%"}]]

           [:filter {:x "-500%", :y "-500%", :width "1000%", :height "1000%", :filterunits "objectBoundingBox", :id "dropshadow-1"}
            [:feoffset {:dy "16", :in "SourceAlpha", :result "shadowOffsetOuter"}]
            [:fegaussianblur {:stddeviation "24", :in "shadowOffsetOuter", :result "shadowBlurOuter"}]
            [:fecolormatrix {:values "0 0 0 0 0.12 0 0 0 0 0.17 0 0 0 0 0.21 0 0 0 0.2 0", :in "shadowBlurOuter"}]]]

          [:g {:fill "none", :fill-rule "evenodd"}
           [:rect {:width "800", :height "450", :rx "4", :fill "#FFF", :style "mix-blend-mode:multiply;filter:url(#dropshadow-1)"}]
           [:rect {:width "800", :height "450", :rx "4", :fill "#FFF"}]
           [:g {:fill "url(#browser-a)", :transform "translate(47 67)"}
            [:path {:d "M146 0h122v122H146zM0 0h122v122H0zM292 0h122v122H292zM438 0h122v122H438zM584 0h122v122H584z"}]]

           [:g {:transform "translate(47 239)", :fill "url(#browser-b)"}
            [:path {:d "M146 0h122v122H146zM0 0h122v122H0zM292 0h122v122H292zM438 0h122v122H438zM584 0h122v122H584z"}]]

           [:path {:fill "url(#browser-c)", :d "M0 146h706v2H0z", :transform "translate(47 67)"}]
           [:g {:transform "translate(0 12)"}
            [:circle {:fill "#FF6D8B", :cx "36", :cy "4", :r "4"}]
            [:circle {:fill "#FFCB4F", :cx "52", :cy "4", :r "4"}]
            [:circle {:fill "#7CE8DD", :cx "68", :cy "4", :r "4"}]
            [:path {:fill "url(#browser-c)", :d "M0 20h800v2H0z"}]
            [:path {:fill "#E3E7EB", :d "M742 2h24v4h-24z"}]]

           [:g
            [:path {:fill "#F6F8FA", :d "M47 385h706v32H47z"}]
            [:path {:fill "#E3E7EB", :d "M356 399h88v4h-88z"}]]]]]


        [:div {:class "bubble-1 is-revealing"}
         [:svg {:width "61", :height "52", :viewbox "0 0 61 52", :xmlns "http://www.w3.org/2000/svg", :xmlns:xlink "http://www.w3.org/1999/xlink"}
          [:defs
           [:path {:d "M32 43.992c17.673 0 28.05 17.673 28.05 0S49.674 0 32 0C14.327 0 0 14.327 0 32c0 17.673 14.327 11.992 32 11.992z", :id "bubble-1-a"}]]

          [:g {:fill "none", :fill-rule "evenodd"}
           [:mask {:id "bubble-1-b", :fill "#fff"}
            [:use {:xlink:href "#bubble-1-a"}]]

           [:use {:fill "#FF6D8B", :xlink:href "#bubble-1-a"}]
           [:path {:d "M2 43.992c17.673 0 28.05 17.673 28.05 0S19.674 0 2 0c-17.673 0-32 14.327-32 32 0 17.673 14.327 11.992 32 11.992z", :fill "#FF4F73", :mask "url(#bubble-1-b)"}]
           [:path {:d "M74 30.992c17.673 0 28.05 17.673 28.05 0S91.674-13 74-13C56.327-13 42 1.327 42 19c0 17.673 14.327 11.992 32 11.992z", :fill-opacity ".8", :fill "#FFA3B5", :mask "url(#bubble-1-b)"}]]]]


        [:div {:class "bubble-2 is-revealing"}
         [:svg {:width "179", :height "126", :viewbox "0 0 179 126", :xmlns "http://www.w3.org/2000/svg", :xmlns:xlink "http://www.w3.org/1999/xlink"}
          [:defs
           [:path {:d "M104.697 125.661c41.034 0 74.298-33.264 74.298-74.298s-43.231-7.425-84.265-7.425S0-28.44 0 12.593c0 41.034 63.663 113.068 104.697 113.068z", :id "bubble-2-a"}]]

          [:g {:fill "none", :fill-rule "evenodd"}
           [:mask {:id "bubble-2-b", :fill "#fff"}
            [:use {:xlink:href "#bubble-2-a"}]]

           [:use {:fill "#838DEA", :xlink:href "#bubble-2-a"}]
           [:path {:d "M202.697 211.661c41.034 0 74.298-33.264 74.298-74.298s-43.231-7.425-84.265-7.425S98 57.56 98 98.593c0 41.034 63.663 113.068 104.697 113.068z", :fill "#626CD5", :mask "url(#bubble-2-b)"}]
           [:path {:d "M43.697 56.661c41.034 0 74.298-33.264 74.298-74.298s-43.231-7.425-84.265-7.425S-61-97.44-61-56.407C-61-15.373 2.663 56.661 43.697 56.661z", :fill "#B1B6F1", :opacity ".64", :mask "url(#bubble-2-b)"}]]]]]]]]




    [:section {:class "features section text-center"}
     [:div {:class "container"}
      [:div {:class "features-inner section-inner has-bottom-divider"}
       [:div {:class "features-wrap"}
        [:div {:class "feature is-revealing"}
         [:div {:class "feature-inner"}
          [:div {:class "feature-icon"}
           [:svg {:width "80", :height "80", :xmlns "http://www.w3.org/2000/svg"}
            [:g {:fill "none", :fill-rule "evenodd"}
             [:path {:d "M48.066 61.627c6.628 0 10.087-16.79 10.087-23.418 0-6.627-5.025-9.209-11.652-9.209C39.874 29 24 42.507 24 49.135c0 6.627 17.439 12.492 24.066 12.492z", :fill-opacity ".32", :fill "#FF97AC"}]
             [:path {:stroke "#FF6D8B", :stroke-width "2", :stroke-linecap "square", :d "M49 45h6V25H35v6M43 55h2v-2M25 53v2h2M27 35h-2v2"}]
             [:path {:stroke "#FF6D8B", :stroke-width "2", :stroke-linecap "square", :d "M43 35h2v2M39 55h-2M33 55h-2M39 35h-2M33 35h-2M45 49v-2M25 49v-2M25 43v-2M45 43v-2"}]]]]


          [:h3 {:class "feature-title"}
           "Stay Safe"]
          [:p {:class "text-sm"}
           "Thousands of websites, of any size have been targets of cryptojacking attacks in the last year"]]]

        [:div {:class "feature is-revealing"}
         [:div {:class "feature-inner"}
          [:div {:class "feature-icon"}
           [:svg {:width "80", :height "80", :xmlns "http://www.w3.org/2000/svg"}
            [:g {:fill "none", :fill-rule "evenodd"}
             [:path {:d "M48.066 61.627c6.628 0 10.087-16.79 10.087-23.418 0-6.627-5.025-9.209-11.652-9.209C39.874 29 24 42.507 24 49.135c0 6.627 17.439 12.492 24.066 12.492z", :fill-opacity ".24", :fill "#75ABF3"}]
             [:path {:d "M34 52V35M40 52V42M46 52V35M52 52V42M28 52V28", :stroke "#4D8EF7", :stroke-width "2", :stroke-linecap "square"}]]]]


          [:h3 {:class "feature-title"}
           "500+ Websites"]
          [:p {:class "text-sm"}
           "We've scoured the internet to find every crypto miner website, and are always looking for more!"]]]]


       [:div {:class "features-wrap"}
        [:div {:class "feature is-revealing"}
         [:div {:class "feature-inner"}
          [:h3 {:class "feature-title"}
           "No Spam"]
          [:p {:class "text-sm"}
           "We'll only email you in case something bad happens. And we won't share your data with anyone!"]]]

        [:div {:class "feature is-revealing"}
         [:div {:class "feature-inner"}
          [:h3 {:class "feature-title"}
           "Free"]
          [:p {:class "text-sm"}
           "This service is proudly offered to you by the two indie makers of "
           [:a {:href "https://magehash.com"} "Magehash"] ". Free of charge, no strings attached."]]]]]]]



    [:section {:class "newsletter section"}
     [:div {:class "container-sm"}
      [:div {:class "newsletter-inner section-inner"}
       [:div {:class "newsletter-header text-center is-revealing"}
        [:h2 {:class "section-title mt-0"}
         "Made by people like you!"]
        [:p {:class "section-paragraph"}
         "We are two makers from Italy 🍕  and the US 🍔"]]]]]]



   [:footer {:class "site-footer text-light"}
    [:div {:class "container"}
     [:div {:class "site-footer-inner"}
      [:div {:class "brand footer-brand"}
       [:img {:src "/unicorn-smaller.png"}]]

      [:ul {:class "footer-links list-reset"}
       [:li
        [:p "Proudly made by"
         [:a {:href "https://magehash.com"}
          " Magehash"]]]]]]]])

(defn action [request]
  (let [[params v-errors] (-> (select-keys (:params request) [:url :email])
                              (validate [[:email [:email]]
                                         [:web-url [:url]]
                                         [:required [:url :email]]])
                              (rescue))
        [_ db-errors] (rescue
                       (transact {:lead/email (:email params)
                                  :lead/url (:url params)}))]
    (if (and (nil? v-errors)
             (nil? db-errors))
      (-> (redirect (url-for :home.index/view))
          (flash "We'll keep an eye on your website! Thanks for supporting your local indie makers!"))
      (view (merge request v-errors db-errors)))))
