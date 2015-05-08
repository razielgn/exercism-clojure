(ns meetup
  (:require [clj-time.core :as t]
            [clj-time.predicates :as p]))

(defn- predicate-for-day [weekday]
  (case weekday
    :monday p/monday?
    :tuesday p/tuesday?
    :wednesday p/wednesday?
    :thursday p/thursday?
    :friday p/friday?
    :saturday p/saturday?
    :sunday p/sunday?))

(defn- find-day [schedule candidates]
  (case schedule
    :first (first candidates)
    :second (second candidates)
    :third (nth candidates 2)
    :fourth (nth candidates 3)
    :teenth (first (drop-while #(< % 13) candidates))
    :last (last candidates)))

(defn- produce-candidates [year month weekday]
  (let [start-date (t/first-day-of-the-month year month)
        end-date (t/last-day-of-the-month year month)
        interval (t/interval start-date end-date)]
    (->> (range (inc (t/in-days interval)))
         (map #(t/plus start-date (t/days %)))
         (filter (predicate-for-day weekday))
         (map t/day))))

(defn meetup [month year weekday schedule]
  (let [day (->> (produce-candidates year month weekday)
                 (find-day schedule))]
    [year month day]))
