(ns fizzbuzz.core-test
  (:require [clojure.test :refer :all]
            [fizzbuzz.core :refer :all]))

(deftest fizzbuzzeia
  (testing "fizz para múltiplos de 3"
    (is (= "fizz" (fizzbuzz 3)))
    (is (= "fizz" (fizzbuzz 12))))

  (testing "buzz para múltiplos de 5"
    (is (= "buzz" (fizzbuzz 5)))
    (is (= "buzz" (fizzbuzz 20)))))
