(ns atbash-cipher
  (:require [clojure.string :as str]))

(defn- char-digit? [ch]
  (java.lang.Character/isDigit ch))

(defn- char-alpha? [ch]
  (java.lang.Character/isLetterOrDigit ch))

(defn- chunks-of [n coll]
  (if (<= (count coll) n)
    (list coll)
    (cons (take n coll)
          (chunks-of n (drop n coll)))))

(defn- invert [c]
  (if (char-digit? c)
    c
    (char (- (+ (int \a) (int \z))
             (int c)))))

(defn encode [plaintext]
  (->> (str/lower-case plaintext)
       (filter char-alpha?)
       (map invert)
       (chunks-of 5)
       (map str/join)
       (str/join " ")))
