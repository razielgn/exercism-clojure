(ns phone-number
  (:require [clojure.string :as str]))

(defn- char-digit? [ch]
  (java.lang.Character/isDigit ch))

(def ^:private invalid-number "0000000000")

(defn number
  "Removes non-numeric characters."
  [string]
  (let [digits (filter char-digit? string)]
    (case (count digits)
      10 (str/join digits)
      11 (if (= \1 (first digits))
           (str/join (rest digits))
           invalid-number)
      invalid-number)))

(defn- break-number [no]
  (let [area-code (subs no 0 3)
        office-code (subs no 3 6)
        line-code (subs no 6 10)]
    (map str/join [area-code
                   office-code
                   line-code])))

(defn area-code
  "Returns a phone number's area code."
  [string]
  (let [no (number string)
        [ac _ _] (break-number no)]
    ac))

(defn pretty-print
  "Pretty prints a phone number with format `(555) 111-2222`."
  [string]
  (let [no (number string)
        [ac oc lc] (break-number no)]
    (format "(%s) %s-%s" ac oc lc)))
