import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tdd.uchit.techmania.data.model.Content
import com.tdd.uchit.techmania.data.model.Post
import com.tdd.uchit.techmania.data.model.Title
import com.tdd.uchit.techmania.data.repository.PostRepositoryImpl
import com.tdd.uchit.techmania.viewmodel.PostViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import java.net.UnknownHostException

@RunWith(BlockJUnit4ClassRunner::class)
class PostViewModelTest {

    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var postRepository: PostRepositoryImpl
    private lateinit var postViewModel: PostViewModel

    private val posts = listOf(
        Post(Title("title"), "image_link", Content("description"), "author", "date1"),
        Post(Title("title1"), "image_link1", Content("description1"), "author1", "date1"),
        Post(Title("title1"), "image_link1", Content("description1"), "author1", "date1")
    )

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        postViewModel = PostViewModel(postRepository)
    }

    @Test
    fun fetchPosts_success() {
        every { postRepository.fetchPosts() }.returns(Single.just(posts))

        //when
        postViewModel.fetchPosts()
        //then
        Assert.assertEquals(posts, postViewModel.posts.value)
    }

    @Test
    fun fetchPosts_networkError() {
        every { postRepository.fetchPosts() }.returns(Single.error(UnknownHostException("ABC")))

        //when
        postViewModel.fetchPosts()

        //then
        Assert.assertEquals(null, postViewModel.posts.value)
    }
}