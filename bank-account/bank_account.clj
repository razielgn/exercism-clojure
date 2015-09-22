(ns bank-account)

(defn open-account []
  (ref 0))

(defn close-account [account]
  (dosync
    (ref-set account nil)))

(defn get-balance [account]
  (dosync
    (deref account)))

(defn update-balance [account amount]
  (dosync
    (alter account + amount)))
