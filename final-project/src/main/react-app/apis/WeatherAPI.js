import {useEffect, useState} from "react";
import {Alert, ImageBackground, StyleSheet, Text, View} from "react-native";
import axios from "axios";
import {VideoBackground} from "./VideoBackground";


const Weather = () =>{
    const [isLoading , setIsLoading] = useState(true);
    const [currentWeather, setCurrentWeather] = useState('');
    const [temp, setTemp] = useState('');
    const [error, setError] = useState(false);

    const API_KEY = "5c109176cb7f758390478b3cbdcc8d63";
    const latitude = 38;
    const longitude = 127;

    const DetailsWeather =()=>{
        navigation
    }

    useEffect(() => {

        let mounted = true;
        const getWeather = async (latitude, longitude) => {
            try {
                const resWeather = await axios.get(
                    `http://api.openweathermap.org/data/2.5/weather?lat=${latitude}&lon=${longitude}&appid=${API_KEY}&units=metric`
                );

                if(mounted) {
                    let main = resWeather.data.weather[0].main;
                    let temp = resWeather.data.main.temp;

                    setCurrentWeather(main);
                    setTemp(temp);
                    setIsLoading(false);
                }

            } catch (error) {
                Alert.alert("날씨 정보를 읽어올 수 없습니다.")
                setError(true);
                setIsLoading(false);
            }

        };

        getWeather(latitude, longitude);

        return()=>{
            mounted = false
        }

    }, []);

    return (
        <>
            <VideoBackground/>
            <ImageBackground style={styles.container}  imageStyle={styles.imgWrapper} source={currentWeather === "Snow" ? require('../assets/snow.jpeg') : require('../assets/favicon.png')}>
                {isLoading || error
                    ? (<Text> Waiting.. </Text>)
                    : (
                        <View style={styles.weather}>
                            <>
                                <Text> {currentWeather} </Text>
                                <Text style={styles.tempNum}> {Math.round(temp)} </Text>
                                <Text style={styles.temp}>°C |°F</Text>
                            </>
                        </View>
                    )
                }
            </ImageBackground>
        </>

    );
};

export default Weather;


const styles = StyleSheet.create({
    container: {
        alignItems:'center',
        justifyContent: 'center',
        width: '90%',
        height: '30%',
        position: 'absolute',
        top: '15%',
        borderRadius: '30%',
    },
    tempNum: {
        fontSize: 50,
        fontWeight: 'bold'
    },
    temp: {
        fontSize: 20,
        fontWeight: 'bold'
    },
    imgWrapper: {
        width:'100%',
        height:'100%',
        borderRadius: '30%'

    },
    video:{

    }

})

