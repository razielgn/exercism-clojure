(ns anagram
  (:require [clojure.string :refer [lower-case]]))

(defn- anagram-of? [word candidate]
  (let [norm-word (lower-case word)
        norm-candidate (lower-case candidate)]
    (if (= norm-word norm-candidate)
      false
      (= (sort norm-word)
         (sort norm-candidate)))))

(defn anagrams-for [word candidates]
  (filter #(anagram-of? word %1) candidates))
