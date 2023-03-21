package io.javaboot.core.common.result;

/**
 * Description:
 *
 * @author iyuLife
 * @date 2023/3/14 10:43
 */
public class PageResultModelSupport<T> extends ResultModelSupport {

    /**
     * 总数
     */
    private int totalCount;

    /**
     * 页数
     *
     * @return
     */
    private int pageSize;

    /**
     * 页码
     *
     * @return
     */
    private int pageIndex;

    @Override
    public int getPageIndex() {
        return pageIndex;
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }
}
