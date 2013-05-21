(ns leiningen.new.mod-cljs
  (:use [leiningen.new.templates :only [renderer name-to-path year ->files]]
        [leinjacker.utils :only [lein-generation]]))

(def project-file
  (if (= (lein-generation) 2)
    "project_lein2.clj"
    "project_lein1.clj"))

(defn mod-cljs
  "Create a new, \"modern-cljs\"-style project"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)
              :year (year)}
        render #((renderer "mod_cljs") % data)]
    (println "Setting up for cljs...")
    (->files data
             [".gitignore" (render "gitignore")]
             ["project.clj" (render "project.clj")]
             ["src/clj/{{sanitized}}/core.clj" (render "core.clj")]
             ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs")]
             ["src/brepl/cljs/{{sanitized}}/connect.cljs" (render "connect.cljs")]
             ["resources/public/simple.html" (render "simple.html")]
             "src/clj"
             "src/cljs"
             "resources/public/js"
             "resources/public/css"
             )))
