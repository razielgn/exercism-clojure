(ns rna-transcription)

(defn- transcribe [nucleotide]
  "Returns the RNA complement of the given DNA neuclotide.
   Throws AssertionError when given an invalid neuclotide."
  (condp = nucleotide
    \G \C
    \C \G
    \T \A
    \A \U
    (throw (AssertionError. "Invalid neuclotide"))))

(defn- chars-to-string [chars]
  "Composes a new string given a chars sequence."
  (apply str chars))

(defn to-rna [dna]
  "Returns the RNA complement of the given DNA."
  (let [rna-chars (map transcribe dna)]
    (chars-to-string rna-chars)))
