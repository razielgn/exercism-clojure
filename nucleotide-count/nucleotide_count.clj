(ns nucleotide-count
  (:require [clojure.core :as core]))

(def ^:private nucleotide-counts-base
  {\A 0 \T 0 \C 0 \G 0})

(defn nucleotide-counts
  "Counts occurrences of each nucleotide inside a DNA string."
  [dna-string]
  (merge nucleotide-counts-base
         (frequencies dna-string)))

(defn count
  "Counts occurrences of a given nucleotide inside a DNA string."
  [nucleotide dna-string]
  (if (contains? #{\A \T \C \G} nucleotide)
    ((nucleotide-counts dna-string) nucleotide)
    (throw (Exception. "invalid nucleotide"))))
