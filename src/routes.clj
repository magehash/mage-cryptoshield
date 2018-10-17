(ns routes)

(def routes [[:get  "/"    :home.index/view         :home.index/view]
             [:post "/"    :home.index/action       :home.index/action]
             [:get  "/404" :error.not-found/view    :404]
             [:get  "/500" :error.server-error/view :500]])
