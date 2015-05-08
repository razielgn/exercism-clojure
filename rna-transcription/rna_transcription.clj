(ns rna-transcription
  (:require [clojure.string :as s]))

(defn- valid-dna-nuclotide? [nucleotide]
  (some (partial = nucleotide) "GCTA"))

(defn- transcribe
  "Returns the RNA complement of the given DNA neuclotide.
   Throws AssertionError when given an invalid neuclotide."
  [nucleotide]
  {:pre [(valid-dna-nuclotide? nucleotide)]}
  (case nucleotide
    \G \C
    \C \G
    \T \A
    \A \U))

(defn to-rna
  "Returns the RNA complement of the given DNA."
  [dna]
  (let [rna-chars (map transcribe dna)]
    (s/join rna-chars)))
