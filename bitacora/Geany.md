# Geany
Configuracions i trucs per a que Geany sigui un bon IDE.

## Instal·lació i personalització

### Preferències

- General > Inici > Fitxers del projecte: /home/manel/workspaces
- Interfície > Interfície > Tipus de lletra: Noto Monospace 12
- Interfície > Barra d'eines > Estil de les icones: Mostra només text
- Editor > Característiques > Columna de trencament de la línia: 120
- Editor > Sagnat > Tipus: espais
- Editor > Completicions > Caràcters autocompletar: 3
- Editor > Completicions > Tancament automàtic: Tot menys cometes simples (apòstrof)
- Editor > Visualització > Barra de marques > Columna: 120
- Vinculació de tecles > Focus > Canvia a finestra missatges: Shift + F2
- Vinculació de tecles > Focus > Canvia a finestra lateral: Ctrl + F2
- Vinculació de tecles > Focus > Commuta a finestra missatges: Ctrl + Alt + M
- Vinculació de tecles > Focus > Commuta a finestra lateral: Ctrl + Alt + L  
- Terminal > Tipus de lletra: Noto Monospace 12

### Instal·lar tema fosc

Copiar la carpeta `colorschemes` a `.config/geany`

Canviar color de la lletra a la consola

### Connectors

Primer que tot instal·lem els plugins 

```
sudo apt install geany-plugins
```

I seleccionem el següents:

- Auto-close
- Auto-mark
- Caràcters HTML
- Depurador
- Lipsum
- Markdown
- Navegació del codi
- Overview
- Pair tag highlighter
- Project Organizer (?)
- Selecció adicional
- Tree browser
- Verifica l'ortografia
- XML PrettyPronter
- SML Snippets

## 27/06/21
Per afegir la funció d'autocompletar és necessari descarregar el fitxer de *tags* i descomprimir-lo al directori:

```
.config/geany/tags
```
