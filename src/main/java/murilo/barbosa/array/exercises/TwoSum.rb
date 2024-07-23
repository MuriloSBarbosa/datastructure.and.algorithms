def two_sum(nums, target)
    map = Hash.new
    
    for i in 0..nums.size
        map[nums[i]] = i
    end

    for i in 0..nums.size
        difference = target - nums[i]
        target_index = map[difference]

        if target_index && target_index != i
            return [i, target_index]
        end
    end

    return []
end