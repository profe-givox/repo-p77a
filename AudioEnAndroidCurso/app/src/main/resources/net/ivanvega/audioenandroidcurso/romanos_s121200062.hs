# uso diccionarios para guardar las equivalencias entre decimales y romanos 

unidad = {0:'',1:'I',2:'II',3:'III',4:'IV',5:'V',6:'VI',7:'VII',8:'VIII',9:'IX'} 

decena = {0:'',1:'X',2:'XX',3:'XXX',4:'XL',5:'L',6:'LX',7:'LXX',8:'LXXX',9:'XC'} 

centena = {0:'',1:'C',2:'CC',3:'CCC',4:'CD',5:'D',6:'DC',7:'DCC',8:'DCCC',9:'XC'} 

unidadMil = {0:'',1:'M',2:'MM',3:'MMM'} 

 

# tomamos el numero convertido a string y lo "disecciona" para poder convertirlo 

# a romano 

def stringARomano(string): 

    numUnidad = unidad[int(string[3])] 

    numDecena = decena[int(string[2])] 

    numCentena = centena[int(string[1])] 

    numUMil = unidadMil[int(string[0])] 

    numRomano = numUMil + numCentena + numDecena + numUnidad 

    return numRomano 

 

# transforma el numero ingresado en string y llama a la funcion stringARomano() 

# pero antes se asegura que tenga 4 cifras agregandole ceros adelante 

def numeroAString(numero): 

    numeroStr = str(numero) 

    if len(numeroStr) == 1: 

        numeroStr = '000' + numeroStr 

    elif len(numeroStr) == 2: 

        numeroStr = '00' + numeroStr 

    elif len(numeroStr) == 3: 

        numeroStr = '0' + numeroStr 

    numRomano = stringARomano(numeroStr) 

    print str(numero) + ' ' + numRomano 

 

 

entrada = 0 

while entrada <= 0 or entrada > 3500:  

    entrada = int(raw_input('Ingrese un número entre 0 y 3500:\n')) 

     

numeroAString(entrada) 