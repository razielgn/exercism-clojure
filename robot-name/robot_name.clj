(ns robot-name)

(defrecord Robot [name])

(defn robot []
  (Robot. (atom "")))

(def letters (map char (range 65 90)))
(def numbers (map char (range 48 58)))

(defn- random-name []
  (let [letter #(rand-nth letters)
        number #(rand-nth numbers)]
    (str (letter) (letter)
         (number) (number) (number) (number))))

(defn robot-name [robo]
  (let [name (:name robo)]
    (if (= "" @name)
      (swap! name str (random-name))
      @name)))

(defn reset-name [robo]
  (let [name (:name robo)]
    (swap! name (fn [_] ""))))
