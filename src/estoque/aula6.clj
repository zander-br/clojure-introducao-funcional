(ns estoque.aula6)

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15 [valor]
  (println "valor" (class valor) valor)
  15)

(println (map imprime-e-15 pedido))

(defn imprime-e-15 [[chave valor]]
  (println "valor" valor)
  15)

(println (map imprime-e-15 pedido))

(defn imprime-e-15 [[chave valor]]
  (println "valor" valor)
  valor)

(println (map imprime-e-15 pedido))

(defn preco-dos-produtos [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

(defn preco-dos-produtos [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

(defn total-do-pedido
  [pedido]
  (->> pedido
      (map preco-dos-produtos)
      (reduce +)))
(println "Total do pedido:" (total-do-pedido pedido))

(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +)))

(println "Total do pedido:" (total-do-pedido pedido))

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}})

(defn gratuito?
  [[_ item]]
  (<= (get item :preco 0) 0))

(println "Filtrando gratuitos")
(println (filter gratuito? pedido ))


(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println "Filtrando gratuitos")
(println (filter (fn [[_ item]] (gratuito? item)) pedido))

(println (filter #(gratuito? (second %)) pedido))

(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

(def pago? (comp not gratuito?))
(println (pago? {:preco 50}))
(println (pago? {:preco 0}))