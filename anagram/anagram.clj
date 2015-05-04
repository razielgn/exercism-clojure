(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn anagrams-for [word candidates]
  (let [word (lower-case word)
        letters (sort word)
        anagram? (fn [cand]
                   (let [cand (lower-case cand)]
                     (if (= word cand)
                       false
                       (= letters (sort cand)))))]
    (filter anagram? candidates)))
