;; Author: Cody Albert
;; Title: Assignment2


;; 1.
;; Return the nth (n) element from a sequence (x).
(defn sdsu-nth
  [x n]
  (first (drop n x)))

(sdsu-nth [:a :b :c 3] 3)
(sdsu-nth '([1 2] [3 4] [5 6]) 3)
(sdsu-nth '(6 5 4 3) 1)


;; 2.
;; Return the nth (n) element from a sequence (x) recursively.
(defn r-sdsu-nth
  [x n]
  (if (zero? n)
    (first x)
    (r-sdsu-nth (rest x) (dec n))))

(r-sdsu-nth '([1 2] [3 4] [5 6]) 2)
(r-sdsu-nth [:a :b :c 3] 0)


;; 3.
;; Reverse a sequence (x) recursively.
(defn sdsu-reverse
  [x]
  (loop [x x y '()]
    (if (empty? x)
      y
      (recur (rest x) (cons (first x) y)))))

(sdsu-reverse [:a :b :c :d :e])
(sdsu-reverse '([1 2] [3 4] [5 6]))
(sdsu-reverse '(1 2 3 4 5 6 7 8))

;; 4.
;; Duplicate each element in a sequence.
(defn sdsu-dup
  [x]
  (loop [x x y []]
    (if (empty? x)
      y
      (recur (rest x) (conj (conj y (first x)) (first x))))))

(sdsu-dup [1 3])
(sdsu-dup [[1 2] [3 4]])
(sdsu-dup '(1 2 3 4 5 6 6 8))


;; 5.
;; Remove consecutive duplicates in a sequence.
(defn sdsu-no-dup
  [x]
  (loop [x x y [] c 0]
    (if (empty? x)
      y
      (if (= (get x c) (get x (+ c 1)))
        (recur (rest (rest x)) (conj y (first x)) (+ c 2))
        (recur (rest x) (y) (+ c 1))))))

(sdsu-no-dup '(1 1 1 1 2 3 3 2 2 3))
(sdsu-no-dup [[1 2] [1 2] [3 4] [1 2]])
(sdsu-no-dup [:a :a :b :b :c])


;; 6.
;; Separate consecutive duplicates in a sequence into sublists.
(defn sdsu-pack
  [x]
  (loop [x x y [] c 0]
    (when (empty? x) y)
    (if (= (get x c) (get x (+ c 1)))
      (recur (rest (drop 1 x)) (conj y (list (get c x) (get (+ c 1) x))) (+ c 2))
      (recur (rest x) (conj y (list (first x))) (+ c 1)))))

