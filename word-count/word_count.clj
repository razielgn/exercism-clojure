(ns word-count
  (:require (clojure.string))
  (:use [clojure.string :only [split replace lower-case]]))

(defn- str-words [string]
  "Splits a string into words, returns a vector of them."
  (split string #" +"))

(defn- str-clean [string]
  "Removes any characters different from letters, numbers and spaces."
  (replace string #"[^a-zA-Z0-9 ]" ""))

(defn word-count [string]
  "Returns a map with occurrences of every word."
  (let [cleaned-string (str-clean string)
        lower-cased (lower-case cleaned-string)
        words (str-words lower-cased)]
    (frequencies words)))
