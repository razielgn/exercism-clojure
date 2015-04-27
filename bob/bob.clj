(ns bob
  (:require [clojure.string :refer [blank?]]))

(defn- char-upper? [ch]
  (java.lang.Character/isUpperCase ch))

(defn- char-letter? [ch]
  (java.lang.Character/isLetter ch))

(defn- upper-case? [str]
  (every? char-upper? str))

(defn- question? [str]
  (= \? (last str)))

(defn- filter-alpha-chars [str]
  (filter char-letter? str))

(defn- yelling? [str]
  (let [str (filter-alpha-chars str)]
    (and (not (empty? str))
         (upper-case? str))))

(defn response-for [msg]
  (cond
    (blank? msg) "Fine. Be that way!"
    (yelling? msg) "Woah, chill out!"
    (question? msg) "Sure."
    :else "Whatever."))
