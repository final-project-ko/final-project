import {Image, StyleSheet, Text, TouchableOpacity, View} from "react-native";
import { ScrollView } from 'react-native-gesture-handler'; 
import {useNavigation} from "@react-navigation/native";
import {useState} from "react";

const News =()=>{

    const navigation = useNavigation();
    const [newsUrl, setNewsUrl] = useState([]);

<<<<<<< HEAD
    const [businessArticles, setBusinessArticles] = useState([]);
    const [entertainmentArticles, setEntertainmentArticles] = useState([]);
    const [techArticles, setTechArticles] = useState([]);
    const [scienceArticles, setScienceArticles] = useState([]);
    const [sportsArticles, setSportsArticles] = useState([]);
    const [healthArticles, setHealthArticles] = useState([]);


    let business = "kr_business";
    let entertainment = "kr_entertainment";
    let technology = "kr_technology";
    let science = "kr_science";
    let sports = "kr_sports";
    let health = "kr_health";


    useEffect(() => {
        const fetchCategoryNews = async () => {
            try {
                const responseBusiness = await fetch(`http://192.168.0.63:8080/api/news/categoryNews/${business}`);
                const dataBusiness = await responseBusiness.json();
                setBusinessArticles(dataBusiness.articles);
                console.log("data", dataBusiness);
                const responseEntertainment = await fetch(`http://192.168.0.63:8080/api/news/categoryNews/${entertainment}`);
                const dataEntertainment = await responseEntertainment.json();
                setEntertainmentArticles(dataEntertainment.articles);

                const responseTech = await fetch(`http://192.168.0.63:8080/api/news/categoryNews/${technology}`);
                const dataTech = await responseTech.json();
                setTechArticles(dataTech.articles);

                const responseSci = await fetch(`http://192.168.0.63:8080/api/news/categoryNews/${science}`);
                const dataSci = await responseSci.json();
                setScienceArticles(dataSci.articles);

                const responseSports = await fetch(`http://192.168.0.63:8080/api/news/categoryNews/${sports}`);
                const dataSports = await responseSports.json();
                setSportsArticles(dataSports.articles);

                const responseHealth = await fetch(`http://192.168.0.63:8080/api/news/categoryNews/${health}`);
                const dataHealth = await responseHealth.json();
                setHealthArticles(dataHealth.articles);

            } catch (error) {
                console.log("Error fetching data", error);
            }
        };
        fetchCategoryNews();
    }, [business, entertainment,technology,science,sports,health]);

// , entertainment,technology,science,sports,health


    return (
=======
    return(
>>>>>>> 30a94975f1bb8a2433eace2ce7d5db7d8e605164
        <View style={styles.container}>
                <View style={styles.separator} />
{/* 
            <View style={styles.categoryContainer1}>
                <ScrollView horizontal = {true}  contentContainerStyle={styles.categoryContainer}  showsHorizontalScrollIndicator={false}>

                    <TouchableOpacity onPress={() => navigation.navigate("SettingScreen2")}>
                        <View style={styles.categoryList}>
                            <Text style={{color:'white' }}>전체</Text>
                        </View>
                    </TouchableOpacity>

                    
                    <View style={styles.categoryList}>
                        <Text style={{color:'white' }}>비즈니스</Text>
                    </View>

                    <View style={styles.categoryList}>
                        <Text style={{color:'white' }}>엔터테인</Text>
                    </View>

                    <View style={styles.categoryList}>
                        <Text style={{color:'white' }}>기술</Text>
                    </View>

                    <View style={styles.categoryList}>
                        <Text style={{color:'white' }}>과학</Text>
                    </View>

                    <View style={styles.categoryList}>
                        <Text style={{color:'white' }}>스포츠</Text>
                    </View>

                    <View style={{ width: 100, alignItems:"center", justifyContent:"center"}}>
                        <Text style={{color:'white' }}>건강</Text>
                    </View>

                </ScrollView>
            </View> */}


            <ScrollView style={styles.totalScrollView} showsVerticalScrollIndicator={false}>

                <Text style={styles.categoryText}>비즈니스</Text>
<<<<<<< HEAD
                <ScrollView style={styles.scrollView} horizontal={true} contentContainerStyle={styles.contentContainer}
                            showsHorizontalScrollIndicator={false}>


                    {businessArticles.map((article, index) => (
                        <TouchableOpacity onPress={() => navigation.navigate("DetailNews", { article, businessArticles})} key={index}>
                            <View style={styles.content}>
                                <Image source={{uri: article.image}} style={styles.image}/>
                                <Text style={styles.articleText}>
                                    {article.title.length > 24 ? article.title.substring(0, 24) + '...' : article.title}
                                </Text>
                            </View>
                        </TouchableOpacity>
                    ))}

=======
                <ScrollView style={styles.scrollView} horizontal = {true}  contentContainerStyle={styles.contentContainer } showsHorizontalScrollIndicator={false} >
                    {/*{newsUrl.map((newsUrl, index) => (*/}
                    <TouchableOpacity onPress={() => navigation.navigate("DetailNews")}>
                        <View style={styles.content}>
                            <Image/>
                            <Text></Text>
                        </View>
                    </TouchableOpacity>
                    {/*))}*/}
>>>>>>> 30a94975f1bb8a2433eace2ce7d5db7d8e605164
                </ScrollView>


                <Text style={styles.categoryText}>엔터테인먼트</Text>
                <ScrollView style={styles.scrollView} horizontal = {true}  contentContainerStyle={styles.contentContainer}  showsHorizontalScrollIndicator={false}>

                    <TouchableOpacity onPress={() => navigation.navigate("DetailNews")}>
                        <View style={styles.content}>
                            <Image/>
                            <Text></Text>
                        </View>
                    </TouchableOpacity>

                </ScrollView>


                <Text style={styles.categoryText}>기술</Text>
                <ScrollView style={styles.scrollView} horizontal = {true}  contentContainerStyle={styles.contentContainer} showsHorizontalScrollIndicator={false}>

                    <TouchableOpacity onPress={() => navigation.navigate("DetailNews")}>
                        <View style={styles.content}>
                            <Image/>
                            <Text></Text>
                        </View>
                    </TouchableOpacity>

                </ScrollView>


                <Text style={styles.categoryText}>과학</Text>
                <ScrollView style={styles.scrollView} horizontal = {true}  contentContainerStyle={styles.contentContainer} showsHorizontalScrollIndicator={false}>

                    <TouchableOpacity onPress={() => navigation.navigate("DetailNews")}>
                        <View style={styles.content}>
                            <Image/>
                            <Text></Text>
                        </View>
                    </TouchableOpacity>

                </ScrollView>


                <Text style={styles.categoryText}>스포츠</Text>
                <ScrollView style={styles.scrollView} horizontal = {true}  contentContainerStyle={styles.contentContainer} showsHorizontalScrollIndicator={false}>

                    <TouchableOpacity onPress={() => navigation.navigate("DetailNews")}>
                        <View style={styles.content}>
                            <Image/>
                            <Text></Text>
                        </View>
                    </TouchableOpacity>

                </ScrollView>


                <Text style={styles.categoryText}>건강</Text>
                <ScrollView style={styles.scrollView} horizontal = {true}  contentContainerStyle={styles.contentContainer} showsHorizontalScrollIndicator={false}>

                    <TouchableOpacity onPress={() => navigation.navigate("DetailNews")}>
                        <View style={styles.content}>
                            <Image/>
                            <Text></Text>
                        </View>
                    </TouchableOpacity>

                </ScrollView>
            </ScrollView>
        </View>
    )

}

export default News;

const styles= StyleSheet.create({
    container: {
        backgroundColor: 'rgba(34,35,38, 1)',
        width:'100%',
        height:'100%',
        padding:'5%'
    },
    categoryList:{
        borderRightWidth: 1,
        borderRightColor: 'grey',
        width: 90,
        alignItems:"center",
        justifyContent:"center"
    },
    categoryContainer:{
        width:630,
        // height:50,
        // backgroundColor:'rgba(50,50,54, 1)',
        // borderRadius: 15,
        // marginBottom: 20,
        // alignItems:"center",
        // justifyContent:"space-between"
    },
    categoryContainer1:{
        width:'100%',
        height:50,
        backgroundColor:'rgba(50,50,54, 1)',
        borderRadius: 15,
        marginBottom: 20,
        alignItems:"center",
        flexDirection: 'row',
        paddingRight: 10,
        paddingLeft: 10,
    },
    categoryText:{
        color: 'rgba(74,185,248, 1)',
        fontSize:16,
        fontWeight: 'bold',
        width:'100%',
        height:30,
        // paddingTop:'5%'
    },
    content:{
        height:180,
        width:170,
        backgroundColor:'rgba(50,50,54, 1)',
        borderRadius: 30,
        marginRight: 10
    },
    scrollView:{
        borderTopWidth: 2,
        borderTopColor: 'grey',
        paddingTop: '5%',
        backgroundColor: 'rgba(34,35,38, 1)',

    },
    contentContainer: {
        flexDirection: 'row', // 컨텐츠를 가로로 배열하기 위해 필요
        paddingRight: 10,
        height:200,
    },
    totalScrollView:{
        height:'100%',
        width:'100%',
        backgroundColor: 'rgba(34,35,38, 1)',
    },
    separator: {
      marginTop: 15,
    },
})