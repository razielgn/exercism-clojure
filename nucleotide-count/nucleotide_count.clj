(ns nucleotide-count
  (:require [clojure.core :as core]))

(defn count
  "Counts occurrences of a given nucleotide inside a DNA string."
  [nucleotide dna-string]
  (let [counter (fn [acc nucleotide']
                  (if (= nucleotide nucleotide')
                    (inc acc)
                    acc))]
    (if (contains? #{\A \T \C \G} nucleotide)
      (reduce counter 0 dna-string)
      (throw (Exception. "invalid nucleotide")))))

(defn nucleotide-counts
  "Counts occurrences of each nucleotide inside a DNA string."
  [dna-string]
  (let [start {\A 0 \T 0 \C 0 \G 0}
        aggregator (fn [h nucleotide]
                     (update-in h [nucleotide] inc))]
    (reduce aggregator start dna-string)))
