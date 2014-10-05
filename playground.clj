






(defn sdsu-dna
  [DNA]
  (let [dna-frequency (frequencies DNA)
        dna-count {:A 0
                   :T 0
                   :G 0
                   :C 0}]
    (assoc
      (assoc
        (assoc
          (assoc dna-count :A (get dna-frequency \A))
          :T (get dna-frequency \T))
        :G (get dna-frequency \G))
      :C (get dna-frequency \C))))







(sdsu-dna "ATTGGGCBHH")




