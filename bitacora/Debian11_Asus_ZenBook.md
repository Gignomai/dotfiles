#Configuracions del Debian 11

Aquí es descriuen totes les modificacions necesaries per a fer servir Debian 11 en el mey ASUS ZenBook

### SUDO

Per afegir l'usuari al grup sudo cal executar com root:

`/sbin/usermod -aG sudo $USER`

Per a que el canvis tinging efecte cal tancar i tornar a iniciar la sessió.

### DRIVERS
Fent servir el `dmesg` podem veure el missatges d'error en arrencar el kernel i veure quins drivers ens manquen.

`sudo dmesg`

`[    2.567651] iwlwifi 0000:01:00.0: firmware: failed to load iwlwifi-8265-36.ucode (-2)`

### VGA

De entrada el ssistema funciona amb un únic monitor i una resol·lució de 800x600:

`manel@manel-zenbook:~$ xrandr`

`xrandr: Failed to get size of gamma for output default`

`Screen 0: minimum 800 x 600, current 800 x 600, maximum 800 x 600`

`default connected primary 800x600+0+0 0mm x 0mm`

`lspci`

`03:00.0 VGA compatible controller: Advanced Micro Devices, Inc. [AMD/ATI] Picasso (rev c1)`

Per tal d'aconseguir els drivers de AMD es necessita instal·lar el repositoris `non-free` i actualitzar l'apt:

`sudo nano /etc/apt/sources.list`

`deb http://deb.debian.org/debian/ buster main non-free contrib`

`deb-src http://deb.debian.org/debian/ buster main non-free contrib`

`deb http://security.debian.org/debian-security buster/updates main contrib non-free`

`deb-src http://security.debian.org/debian-security buster/updates main contrib non-free`

`sudo apt update`


### WIFI

De sortida Debian no instala el drivers del adaptador de xarxa Intel perque son propietairs, cal instalar-los un cop configurats els repositoris non-free. 

`$ lspci`

`01:00.0 Network controller [0280]: Intel Corporation Wireless 8265 / 8275 [8086:24fd] (rev 78)`

`sudo apt install firmware-iwlwifi`

`sudo modprobe -r iwlwifi`

`sudo modprobe iwlwifi`

### XMODMAP

Per tal de fer servir el teclat mecànic de 60% s'ha de instal·lar el programa `xmodmap` i executar-lo en les sessions en les que fem servir el teclat.
Si volem tornar a fer servir el teclat _estàndard_ tornarem a fer servir `xmodmap` per tornar a la configuració inicial:

`sudo apt-get install xmodmap`

`xmodmap -pke > xmodmao_original`

`xmodmap .xmodmaprc`

`xmodmap xmodmap_original`

EL fitxer `.xmodmaprc` el desarem en el directori _home_ de l'usuari i contindrá només les línies de les tecles que canvien:

`keycode  52 = z Z z Z less guillemotleft z Z`

`keycode  53 = x X x X greater guillemotright x X`

`keycode 108 = Menu NoSymbol Menu NoSymbol Menu`

`keycode 135 = ISO_Level3_Shift NoSymbol ISO_Level3_Shift NoSymbol ISO_Level3_Shift`

### ZSH

Instalarem la consola `Tilix` i el programa `tmux` per començar, després instalarem `Zsh` i `Oh-My-Zsh`... (més detall al seu propi document)

`sudo apt install tilix tmux`

`sudo apt-get install zsh`

`sh -c "$(curl -fsSL https://raw.github.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"`

Aprofitarem per afegir alguns alies per fer més fàcil la feina:

```
alias cp="cp -i"                                                # Confirm before overwriting something
alias df='df -h'                                                # Human-readable sizes
alias free='free -m'                                            # Show sizes in MB

alias ll='ls -lh'
alias la='ls -lah'

alias gst='git status'
alias ga='git add .'
alias gc='git commit -m'
alias gco='git checkout'
alias gcb='git checkout -b'
alias gitu='git add . && git commit && git push'

alias install='sudo apt install'
```

### GIT

A més de instalar `git` l'hem de configurar per poder fer servir els repositoris de github.

`install git`

Per a generar les claus SSH cal seguir les instruccions que trobem [aquí](https://docs.github.com/en/github/authenticating-to-github/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent).

També afegirem una interfaç gràfica per al git `GitAhead` que descarreguem de la [pàgina oficial](https://gitahead.github.io/gitahead.com/), movem a _workspaces_ i executem:

`sh GitAhead-2.6.3.sh`

### DOCKER

Instalarem Docker i Docker-Compose:

`install docker docker-compose`

Iniciarem el servei de docker:

`sudo systemctl start docker`

I afegirem l'usuari al grup docker:

`/sbin/usermod -aG docker $USER`

Com sempre tamcarem sessió per fer efectius els canvis, i si no funcionen reiniciem.

### GNOME EXTENSIONS

Per poder instalar el portapapers a la barra d'eïnes ho farem amb l'_AddOn_ del FIrefox _Gnome Extensions_ ( la icona que trobem a la barra d'eïnes amb la forma del peu de Gnome). 
Al fer click en el peu ens obre la página de extensions per al Gnome i podem buscar _Clipboard Indicator_ i activar per tenir el nostre portapapers activar a la barra d'eïnes.


### GNOME CONFIG

Per fer Alt+Tab només amb les finestres de l'espai de treball actual s'ha d'executar la següent ordre:

`gsettings set org.gnome.shell.app-switcher current-workspace-only true` 

### GEANY

Cal afegir geany per a tenir un editor de textos com cal... (més detall al seu propi document)

`sudo apt install geany`

### CHROME

Google Chrome tampoc és als repositoris oficials de Debian, així que l'hem de afegir desde fora.

`wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb`

`sudo apt install ./google-chrome-stable_current_amd64.deb`

Això també instala el repositori oficial a `/etc/apt/sources.list.d/google-chrome.list`.

### SDKMAN

Per a gestionar les versions del diferents sdks, jdks, etc. farem servir SdkMan:

`curl -s "https://get.sdkman.io" | bash`

`source "$HOME/.sdkman/bin/sdkman-init.sh"`

### INTELLIJ

Per a instalar IntelliJ necesitem snapd:

`sudo apt install snapd`

`sudo snapd install core`

`sudo snap install intellij-idea-community --classic`

Ara cal crear un llençador per l'aplicació a `.local/share/applications`:

`touch intellij-idea-community.desktop`

### SPOTIFY

Farem servir snapd igual que amb IntelliJ:

`sudo snap install spotify`
`touch spotify.desktop`


