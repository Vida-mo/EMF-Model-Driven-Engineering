# Model-Driven Software Engineering (MDSE) & EMF Portfolio

Dieses Repository ist ein kompaktes Showcase für **modellgetriebene Softwareentwicklung (MDSE / MDD)** und **Domain-Specific Languages (DSL)** auf Basis des **Eclipse Modeling Frameworks (EMF)**, **Eclipse Xtext** und **Java 21**. 

Es demonstriert praxisnah zentrale Konzepte und Entwurfsmuster moderner Modellierungs-Ökosysteme am Beispiel von **Event Modeling**:

* **Metamodellierung mit Ecore:** Definition domänenspezifischer Metamodelle für Event Modeling (Slices, Commands, Events) und objektorientierte Zielsprachen.
* **Domain-Specific Languages (DSL):** Entwicklung textueller Modellierungssprachen mit Xtext inklusive Grammatikdefinition, Scoping, Validierung und IDE-Integration.
* **Model-to-Model (M2M) Transformation:** Semantische Transformation von abstrakten Event-Modeling-Modellen in strukturierte Zielmetamodelle (z. B. Java-Metamodell).
* **Model-to-Text (M2T) Codegenerierung:** Automatisierte Erzeugung von typsicherem Java-Quellcode aus Instanzmodellen (Xtend- und Java-basierte Generatoren).
* **EMF-Reflexion & Metamodellnavigation:** Dynamische Inspektion und Traversierung von Modellen und Metamodellen zur Laufzeit über Ecore-APIs (`EObject`, `EClass`, `EStructuralFeature`).
* **Interoperabilität & Import:** Einbindung externer Modellformate (z. B. JSON-Exporte aus Nebulit Event Modeling) in das EMF-Ökosystem.

---

### 📂 Projektstruktur

- [`event_modeling_metamodel/`](./event_modeling_metamodel/) — Ecore-Metamodell für Event Modeling (Slices, Commands) & EMF GenModel
- [`event_modeling_dsl/`](./event_modeling_dsl/) — Textuelle DSL mit Eclipse Xtext & Xtend-Codegenerator für Event-Modelle
- [`simple_java/`](./simple_java/) — Java-Zielmetamodell, Model-to-Model (M2M) Transformation & M2T Java-Codegenerator
- [`event_modeling_code_generator/`](./event_modeling_code_generator/) — Programmatische Modellerstellung, XMI-Serialisierung & Generierungs-Pipeline
- [`nebulit_json_importer/`](./nebulit_json_importer/) — Import & Mapping von Nebulit JSON Event-Modeling-Exporten nach EMF
- [`ecore-demos/`](./ecore-demos/) — Reflexive Metamodellnavigation und generische Inspektion von Ecore-Modellen

---

**Tech-Stack:** Java 21, Eclipse Modeling Framework (EMF), Eclipse Xtext 2.39, Xtend, Ecore, XMI (XML Metadata Interchange).
