(defproject program ""

  :dependencies
  [[org.clojure/clojure "1.10.3"]
   [org.clojure/core.async "1.5.648"]

   [com.formdev/flatlaf "2.1"]
   [com.formdev/flatlaf-extras "2.1"]
   [com.miglayout/miglayout-swing "5.3"]]

  :source-paths ["src"]
  :target-path "out"
  :main Kylo-Ren.main
  :profiles {:uberjar {:aot :all}}
  :repl-options {:init-ns Kylo-Ren.main}
  :jvm-opts ["-Dclojure.compiler.direct-linking=true"]
  :uberjar-name "Kylo-Ren.jar")