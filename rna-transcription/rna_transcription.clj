(ns rna-transcription)

(defn- valid-dna-nuclotide? [nucleotide]
  (some #(= nucleotide %) "GCTA"))

(defn- transcribe
  "Returns the RNA complement of the given DNA neuclotide.
   Throws AssertionError when given an invalid neuclotide."
  [nucleotide]
  {:pre [(valid-dna-nuclotide? nucleotide)]}
  (condp = nucleotide
    \G \C
    \C \G
    \T \A
    \A \U))

(defn- chars-to-string
  "Composes a new string given a chars sequence."
  [chars]
  (apply str chars))

(defn to-rna
  "Returns the RNA complement of the given DNA."
  [dna]
  (let [rna-chars (map transcribe dna)]
    (chars-to-string rna-chars)))
