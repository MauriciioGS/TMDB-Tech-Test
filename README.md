# TMDB Android Technical Test

## Faltantes / Futuras mejoras

- Mostrar Series al aire y populares
Faltó tiempo para hacer la implementación de las series. Dicha implementación es muy similar a lo ya realizado: definir los endpoints, los módulos de inyección de dependencias, repositorios, data souces, casos de uso, view models y llenado de los recycler views
- Soporte offline
Para dar soporte offline, al momento de consumir los servicios, desde el ViewModel mandar a llenar una DB local hecha con Room. Dicha implementación colocada en el módulo de storage con su data source, repositorios, casos de uso y modelos/entidades. Una vez llenada la base de datos, se utiliza esta información para los RecyclerView para no depender de la conexión, o sse puede monitorear la conexión para saber el estado
- Video en detalle
Añadir api para reproducri video consumiendo el servicio
- Correcta navegación de listados a detalle 
Que abrir al abrir detalle sea correcta la navegación
