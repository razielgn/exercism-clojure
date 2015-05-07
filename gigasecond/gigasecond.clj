(ns gigasecond
  (:require [clj-time.core :as t]))

(defn from [year month day]
  (let [date (t/date-time year month day)
        anniversary (t/plus date
                            (t/years 31)
                            (t/days 251)
                            (t/hours 1)
                            (t/minutes 46)
                            (t/seconds 40))]
    [(t/year anniversary)
     (t/month anniversary)
     (t/day anniversary)]))
