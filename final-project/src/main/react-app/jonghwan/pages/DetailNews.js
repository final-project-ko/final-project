import {StatusBar, StyleSheet, Text, View} from "react-native";

const DetailNews = ()=>{


    return(
        <>
            <StatusBar />
            <View style={styles.container}>
                <Text>sdfsd</Text>
            </View>
        </>

    )
}

export default DetailNews;

const styles = StyleSheet.create({
    container: {
        backgroundColor: 'rgba(34,35,38, 1)',
        flex:1,
        padding:'20%'
    },
})