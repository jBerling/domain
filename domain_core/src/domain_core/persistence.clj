(ns domain-core.persistence
  (:refer-clojure :exclude [conj! disj!]))

(defprotocol Persistence
  (select [this] [this predicate] [this predicate collects])
  (project [this] [this fields])
  (conj! [this] [this records])
  (disj! [this] [this predicate])
  (update-in! [this] [this predicate] [this predicate record]))

(defmacro ->1 [& steps]
  `(-> ~@steps
       deref
       first))