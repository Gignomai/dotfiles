# ZSH

## Instalació

Instalarem la consola `Tilix` i el programa `tmux` per començar:

`sudo apt install tilix tmux`

Ara instalarem `Zsh`:

`sudo apt-get install zsh`

`zsh --version`

Per afegir temes i plugins farem servir `Oh-My-Zsh`. Tenim dues opcions d'instalació:

`sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"`

`sh -c "$(wget https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh -O -)"`

Farà falta instalar `curl`, si volem aquesta opció, i `git`. Totes dues son necesaries així que les instalo.

També cal fer que `zsh` sigui el nostre _shell_ per defecte:

`chsh -s $(which zsh)`

## Temes

Escollim un tema de OhMyZsh per fer més bonica la terminal editant el fitxer `.zshrc` 

`ZSH_THEME="agnoster"` 

Per a poder mostrar les icones a la terminal cal instalar les fonts _PowerLine_

`sudo apt-get install fonts-powerline`

## Plugins

També podem decidir quin plugins farem servir dels que venen amb OhMyZsh editant `.zshrc`:

`plugins=(git history-substring-search docker docker-compose)`

A més he afegit configuración propies del Zsh que no son de OhMyZsh i un plugin que s'instala desde `apt`:

`sudo apt install zsh-syntax-highlighting`

I afegim el següent a `.zshrc`:

`## Plugins section: Enable fish style features`

`# Use syntax highlighting`

`source /usr/share/zsh-syntax-highlighting/zsh-syntax-highlighting.zsh`

## Canvis

Cada cop que fem canvis al fitxer `.zshrc` hem de tancar la sessió de terminal sortint o executant el següent:

`source {$USER_HOME}/.zshrc` 

