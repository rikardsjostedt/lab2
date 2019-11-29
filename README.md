# Laboration 2 

##Uppgift 2A

###Refaktoriseringsplan
1. Skapa en mainklass där programmets olika komponenter (`DrawPanel`, `VehicleView`, `VehicleController`) initialiseras.
2. `VehicleGraphic` ska sammankoppla logiken för ett fordon med en bild för det, för att undvika separata listor med information.
3. Skapa `VehicleGraphics` från controllern istället för i `DrawPanel` då den logiken inte hör hemma där.


Andra tankar:
- Försöka undvika `instanceof` i controllerkoden för att hantera `Turbo` och `Flatbed`.
- Hur undvika cirkulärt beroende mellan `VehicleView` och `VehicleController` för user inputs?

