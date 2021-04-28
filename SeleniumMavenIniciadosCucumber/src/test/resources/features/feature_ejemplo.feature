Feature: Google busca wikipedia

	Scenario: Buscar Wikipedia
		Given Nos encontramos en la pagina de google
		When Buscamos wikipedia y entramos en el primer resultado
		Then El titulo del articulo bueno del dia es "Conferencia de Carnunto"