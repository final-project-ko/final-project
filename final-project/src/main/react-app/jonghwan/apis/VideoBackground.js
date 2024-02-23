import Video from 'react-native-video';
// import video from '../';

const MyComponent = () => {
    const videoPlayer = React.useRef();

    const goFullScreen = () => {
        if (videoPlayer.current) {
            videoPlayer.current.presentFullscreenPlayer();
        }
    };

    return (
        <Video
            ref={ref => (videoPlayer.current = ref)}
            source={video}                  // the video file
            paused={false}                  // make it start
            style={styles.backgroundVideo}  // any style you want
            repeat={true}                   // make it a loop
        />
    )
}

export default MyComponent;