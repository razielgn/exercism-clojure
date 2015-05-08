(ns beer-song
  (:require [clojure.string :as s]))

(defn- bottles-of-beer [n]
  (case n
    0 "no more bottles of beer"
    1 "1 bottle of beer"
    (str n " bottles of beer")))

(defn- first-line [n]
  (let [bottles (bottles-of-beer n)]
    (format "%s on the wall, %s.\n"
            (s/capitalize bottles)
            bottles)))

(defn- second-line [n]
  (if (zero? n)
    (format "Go to the store and buy some more, %s on the wall.\n"
            (bottles-of-beer 99))
    (let [bottles (bottles-of-beer (dec n))
          obj-complement (if (= n 1) "it" "one")]
      (format "Take %s down and pass it around, %s on the wall.\n"
              obj-complement
              bottles))))

(defn verse [n]
  (str (first-line n)
       (second-line n)))

(defn sing
  ([from]
   (sing from 0))
  ([from to]
   (->> (range to (inc from))
        reverse
        (map verse)
        (reduce #(str %1 "\n" %2)))))
