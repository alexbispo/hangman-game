(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (println "Você perdeu!"))
(defn ganhou [] (println "Você ganhou!"))

(defn letras-restantes [palavra acertos]
  (remove #(contains? acertos (str %)) palavra))

(defn acertou-a-palavra-toda? [palavra acertos]
  (empty? (letras-restantes palavra acertos)))

(defn jogo [vidas palavra acertos]
  (if (= vidas 0)
    (perdeu)
    (if (acertou-a-palavra-toda? palavra acertos)
      (ganhou)
      (println "Chuta amigo!"))))

(def palavra (set ["A" "L" "U" "R"]))

(and (contains? palavra "A") (contains? palavra "O"))

(defn -main
  "Start..."
  [& args]
  (println "Jogo da Forca em desenvolvimento..."))
