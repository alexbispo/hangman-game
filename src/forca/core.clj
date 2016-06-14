(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (println "Você perdeu!"))
(defn ganhou [] (println "Você ganhou!"))

(defn letras-restantes [palavra acertos]
  (remove #(contains? acertos (str %)) palavra))

(defn acertou-a-palavra-toda? [palavra acertos]
  (empty? (letras-restantes palavra acertos)))

(defn acertou-chute? [chute palavra]
  (.contains palavra chute))

(defn le-chute! []
  (read-line))

(defn jogo [vidas palavra acertos]
  (if (= vidas 0)
    (perdeu)
    (if (acertou-a-palavra-toda? palavra acertos)
      (ganhou)
      (let [chute (le-chute!)]
        (if (acertou-chute? chute palavra)
          (jogo vidas palavra (conj acertos chute))
          (jogo (dec vidas) palavra acertos))))))

(defn -main
  "Start..."
  [& args]
  (println "Hello world!"))
