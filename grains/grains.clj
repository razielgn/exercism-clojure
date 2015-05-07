(ns grains)

(defn- grains-seq
  ([]  (grains-seq 1))
  ([n] (cons n (lazy-seq (grains-seq (*' n 2))))))

(defn square [n]
  (nth (grains-seq) (dec n)))

(defn total []
  (let [grains (take 64 (grains-seq))]
    (reduce +' grains)))
