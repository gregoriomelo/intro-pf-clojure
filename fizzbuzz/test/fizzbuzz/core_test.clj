(ns fizzbuzz.core-test
  (:require [clojure.test :refer :all]
            [fizzbuzz.core :refer :all]))

(deftest ta-rodando
  (testing "Tá rodando"
    (is (= "Oi!" (oi)))))
