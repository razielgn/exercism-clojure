(ns roman-numerals)

(def ^:private translation-table
  [[1000 "M"]
   [900  "CM"]
   [500  "D"]
   [400  "CD"]
   [100  "C"]
   [90   "XC"]
   [50   "L"]
   [40   "XL"]
   [10   "X"]
   [9    "IX"]
   [5    "V"]
   [4    "IV"]
   [1    "I"]])

(defn- choose-adequate-roman [dec-n]
  (first
    (filter (fn [[rom-n _]] (>= dec-n rom-n))
            translation-table)))

(defn numerals [n]
  (loop [dec-n n
         out-rom-s ""]
    (if-let [[rom-n rom-s] (choose-adequate-roman dec-n)]
      (recur (- dec-n rom-n)
             (str out-rom-s rom-s))
      out-rom-s)))
