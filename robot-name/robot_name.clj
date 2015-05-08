(ns robot-name)

(defn robot []
  {:name (atom "")})

(def ^:private letters (map char (range 65 90)))
(def ^:private numbers (map char (range 48 58)))

(defn- random-name []
  (let [letter #(rand-nth letters)
        number #(rand-nth numbers)]
    (str (letter) (letter)
         (number) (number) (number))))

(defn robot-name [robo]
  (let [name (:name robo)]
    (if (= "" @name)
      (swap! name str (random-name))
      @name)))

(defn reset-name [robo]
  (let [name (:name robo)]
    (swap! name (fn [_] ""))))
