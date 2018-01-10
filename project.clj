(defproject starcity/toolbelt-async "0.4.0"
  :description "Utilities for working with core.async"
  :url "https://github.com/starcity-properties/toolbelt-async"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0" :scope "provided"]
                 [org.clojure/core.async "0.3.465" :scope "provided"]
                 [starcity/toolbelt-core "0.3.0"]]
  :deploy-repositories [["releases" {:url   "https://clojars.org/repo"
                                     :creds :gpg}]])
