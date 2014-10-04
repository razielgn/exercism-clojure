(ns bob)

(defn question? [msg]
  (= \? (last msg)))

(defn nothing? [msg]
  (empty? (clojure.string/trim msg)))

(defn anything? [msg]
  (re-find #"[a-zA-Z0-9]+" msg))

(defn str-only-alpha [msg]
  (let [patt #"[^a-zA-Z]"]
    (clojure.string/replace msg patt "")))

(defn yelling? [msg]
  (let [msg' (str-only-alpha msg)]
    (and (anything? msg')
         (= msg' (clojure.string/upper-case msg')))))

(defn response-for [msg]
  (cond
    (nothing? msg) "Fine. Be that way!"
    (yelling? msg) "Woah, chill out!"
    (question? msg) "Sure."
    :else "Whatever."))
