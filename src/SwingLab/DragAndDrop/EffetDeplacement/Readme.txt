Drag and drop avec effet de déplacement
Source : https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java/25892-decouvrez-le-drag-drop

Classes :
- MyGlassPane : JPanel avec transparence pour affichage de l'objet en cours de déplacement.
Initialisé avec l'image du composant à déplacer.
- MouseGlassListener : gère 2 événements
    - MousePressed : initialisation de l'objet MyGlassPane avec l'image du composant à déplacer
    - MouseReleased : effectue le drop et efface l'image de l'objet MyGlassPane
- MouseGlassMotionListener : gère le déplacement de l'image avec le déplacement de la souris
