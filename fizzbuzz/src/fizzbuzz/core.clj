(ns fizzbuzz.core)

(defn fizzbuzz [numero]
  (cond (zero? (mod numero 3)) "fizz"
        (zero? (mod numero 5)) "buzz"
        :else numero))
