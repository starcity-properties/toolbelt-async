(ns toolbelt.async-test
  (:require [clojure.test :refer :all]
            [clojure.core.async :as async]
            [toolbelt.async :refer :all]))

(def sentinel ::sentinel)


(defn- sentinel-chan []
  (let [c (async/chan)]
    (async/put! c sentinel)
    c))


(defn- throwable-chan []
  (let [c (async/chan)]
    (async/put! c (ex-info "throwable" {}))
    c))


(deftest testing-<!!?
  (testing "it performs like core.async `<!!` when taking non-throwables"
    (is (= sentinel (<!!? (sentinel-chan)))))

  (testing "it throws exceptions when taking throwables"
    (is (thrown? clojure.lang.ExceptionInfo (<!!? (throwable-chan))))))


(deftest testing-chan?
  (is (chan? (async/chan)))
  (is (not (chan? :not-a-chan))))
