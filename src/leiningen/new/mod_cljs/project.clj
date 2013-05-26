(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  ;; CLJ source code path
  :source-paths ["src/clj"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [domina "1.0.2-SNAPSHOT"]
                 [hiccups "0.2.0"]
                 [shoreleave/shoreleave-remote-ring "0.3.0"]
                 [shoreleave/shoreleave-remote "0.3.0"]]

  :plugins [;; cljsbuild plugin
            [lein-cljsbuild "0.3.0"]

            ;; ring plugin
            [lein-ring "0.8.3"]]

  ;; ring tasks configuration
  :ring {:handler {{name}}.core/handler}

  ;; cljsbuild options configuration
  :cljsbuild { ;; :crossovers [] ;; uncomment and add the namespaces to share between clj and cljs
              :builds
              {
               :dev
               {;; CLJS source code path
                :source-paths ["src/cljs" "src/brepl/cljs"]

                ;; Google Closure (CLS) options configuration
                :compiler {;; CLS generated JS script filename
                           :output-to "resources/public/js/core.js"

                           ;; minimal JS optimization directive
                           :optimizations :whitespace

                           ;; generated JS code prettyfication
                           :pretty-print true}}
               :prod
               {;; clojurescript source code path
                :source-paths ["src/cljs"]

                ;; Google Closure Compiler options
                :compiler {;; the name of emitted JS script file
                           :output-to "resources/public/js/core.js"

                           ;; advanced optimization
                           :optimizations :advanced}}
              :pre-prod
              {;; CLJS source code path
                :source-paths ["src/cljs" "src/brepl/cljs"]

                ;; Google Closure (CLS) options configuration
                :compiler {;; CLS generated JS script filename
                           :output-to "resources/public/js/core.js"

                           ;; minimal JS optimization directive
                           :optimizations :simple

                           ;; no prettyfication
                           }}})