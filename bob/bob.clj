(ns bob
  (:require [clojure.string :refer [blank?]]))

(defn- char-upper? [ch]
  (java.lang.Character/isUpperCase ch))

(defn- char-letter? [ch]
  (java.lang.Character/isLetter ch))

(defn- upper-case? [s]
  (every? char-upper? s))

(defn- question? [s]
  (= \? (last s)))

(defn- filter-alpha-chars [s]
  (filter char-letter? s))

(defn- yelling? [s]
  (let [s (filter-alpha-chars s)]
    (and (seq s)
         (upper-case? s))))

(defn response-for [msg]
  (cond
    (blank? msg) "Fine. Be that way!"
    (yelling? msg) "Woah, chill out!"
    (question? msg) "Sure."
    :else "Whatever."))
